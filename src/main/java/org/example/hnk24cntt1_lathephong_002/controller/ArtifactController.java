package org.example.hnk24cntt1_lathephong_002.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.hnk24cntt1_lathephong_002.model.Artifact;
import org.example.hnk24cntt1_lathephong_002.repository.ArtifactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ArtifactController {
    private final ArtifactRepository artifactRepository;
    @GetMapping
    public String listArtifacts(@RequestParam(defaultValue = "0") int page, @RequestParam(required = false) String key, Model model) {
        Page<Artifact> artifactPage = artifactRepository.findAll(PageRequest.of(page, 5));
        model.addAttribute("artifacts", artifactPage);
        model.addAttribute("key", key);
        return "artifact-list";
    }
    @GetMapping("/create")
    public String createArtifact(Model model) {
        model.addAttribute("artifact", new Artifact());
        return "artifact-form";
    }
    @PostMapping("/save")
    public String saveArtifact(@Valid @ModelAttribute Artifact artifact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "artifact-form";
        }
        artifactRepository.save(artifact);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editArtifact(@PathVariable("id") Long id, Model model) {
        model.addAttribute("artifact", artifactRepository.findById(id).orElse(null));
        return "artifact-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteArtifact(@PathVariable("id") Long id) {
        artifactRepository.deleteById(id);
        return "redirect:/";
    }
    @PostMapping("/edit/{id}")
    public String updateArtifact(@PathVariable("id") Long id, @ModelAttribute Artifact artifact) {
        artifactRepository.save(artifact);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String searchArtifacts(@RequestParam String key, Model model) {
        model.addAttribute("artifacts", artifactRepository.findByNameContainingIgnoreCase(key, PageRequest.of(0, 5)));
        return "artifact-list";
    }

}

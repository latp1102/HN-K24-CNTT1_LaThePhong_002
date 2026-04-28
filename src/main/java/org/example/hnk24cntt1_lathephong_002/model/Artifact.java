package org.example.hnk24cntt1_lathephong_002.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "artifact")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên ko đc để trống")
    @Size(min=5,max = 150, message = "Tên phải từ 5-150 ký tự")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "nguồn gốc ko đc để trống")
    @Column(name = "origin")
    private String origin;
    @NotNull(message = "ngày không được để trống")
    @PastOrPresent(message = "ngày không hợp lệ")
    @Column(name = "date")
    private LocalDate date;
}

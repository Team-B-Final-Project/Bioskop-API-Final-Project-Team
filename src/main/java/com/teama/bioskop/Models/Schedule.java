package com.teama.bioskop.Models;


import com.teama.bioskop.DTO.ScheduleResponseDTO;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name ="film_code")
    private Films films;
    private Date tanggalTayang;
    private Time jamMulai;
    private Time jamSelesai;
    private Double hargaTiket;


    public ScheduleResponseDTO convertToResponse(){
        return ScheduleResponseDTO.builder().
                films(this.films).tanggalTayang(this.tanggalTayang).jamMulai(this.jamMulai).
                jamSelesai(this.jamSelesai).hargaTiket(this.hargaTiket).build();
    }

}
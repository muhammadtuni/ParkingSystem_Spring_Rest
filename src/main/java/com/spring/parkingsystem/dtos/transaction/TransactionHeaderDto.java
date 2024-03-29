package com.spring.parkingsystem.dtos.transaction;

import com.spring.parkingsystem.models.Transaction;
import com.spring.parkingsystem.utility.MapperHelper;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class TransactionHeaderDto {
    private Integer id;
    private String kendaraan;
    private LocalDateTime jam;
    private LocalDate tanggal;
    private Integer tarif;
    private Integer tariflanjut;

    public TransactionHeaderDto(Object entity) {
        this.id = MapperHelper.getIntegerField(entity, "id", Transaction.class);
        this.jam = MapperHelper.getLocalDateTimeField(entity, "jamMasuk", Transaction.class);
        this.tanggal = MapperHelper.getLocalDateField(entity, "tanggalMasuk", Transaction.class);
    }

    public static TransactionHeaderDto set(Transaction transaction){
        return new TransactionHeaderDto(transaction.getId(), transaction.getJenisKendaraan().getId(), transaction.getJamMasuk(), transaction.getTanggalMasuk(), transaction.getJenisKendaraan().getTarif(), transaction.getJenisKendaraan().getTariflanjut());
    }
}

package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Document;
import lombok.Data;

@Data
public class DocumentDTO {
    private Long documentId;
    private String documentName;
    private String documentCode;

    public static DocumentDTO fromEntity(Document entity){
        DocumentDTO tmp = new DocumentDTO();

        tmp.setDocumentId(entity.getDocumentId());
        tmp.setDocumentName(entity.getDocumentName());
        tmp.setDocumentCode(entity.getDocumentCode());

        return tmp;
    }
}

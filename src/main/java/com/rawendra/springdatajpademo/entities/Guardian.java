package com.rawendra.springdatajpademo.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "guardianName")),
        @AttributeOverride(name = "email", column = @Column(name = "guardianEmailId")),
        @AttributeOverride(name = "mobile", column = @Column(name = "guardianMobile"))

})
public class Guardian {
    private String name;//guardianName;
    private String email;//guardianEmailId;
    private String mobile;//guardianMobile;
}

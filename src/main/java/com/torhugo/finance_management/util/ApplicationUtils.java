package com.torhugo.finance_management.util;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class ApplicationUtils {

    public String isStringNull(final String atribute){
        return isNull(atribute).equals(Boolean.FALSE) ? atribute : null;
    }
    public Boolean isNull(final String atribute){
        return atribute == null ? Boolean.TRUE : Boolean.FALSE;
    }
    public Long convertToLong(final Long atribute){
        if (atribute == null)
            return null;
        else
            return Long.valueOf(isStringNull(String.valueOf(atribute)));
    }
    public BigDecimal convertToBigDecimal(final BigDecimal atribute){
        if (atribute == null)
            return null;
        else
            return BigDecimal.valueOf(Long.parseLong(isStringNull(String.valueOf(atribute))));
    }
    public LocalDate validationExistingDate(final LocalDate atribute){
        if (atribute == null)
            return LocalDate.now();
        else
            return atribute;
    }
}

package others;

import enums.SublineaAccion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SublineaAccionConverter implements AttributeConverter<SublineaAccion, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SublineaAccion attribute) {
        return attribute.ordinal() + 1;
    }

    @Override
    public SublineaAccion convertToEntityAttribute(Integer dbData) {
        return SublineaAccion.values()[dbData - 1];
    }
}

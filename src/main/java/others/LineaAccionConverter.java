package others;

import enums.LineaAccion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LineaAccionConverter implements AttributeConverter<LineaAccion, Integer> {
    @Override
    public Integer convertToDatabaseColumn(LineaAccion attribute) {
        return attribute.ordinal() + 1;
    }

    @Override
    public LineaAccion convertToEntityAttribute(Integer dbData) {
        return LineaAccion.values()[dbData - 1];
    }
}

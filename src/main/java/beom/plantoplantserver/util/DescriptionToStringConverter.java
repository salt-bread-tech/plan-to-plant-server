package beom.plantoplantserver.util;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
@Slf4j
public class DescriptionToStringConverter implements AttributeConverter<PlantDescription,String>{

    @Override
    public String convertToDatabaseColumn(PlantDescription attribute) {
        if(attribute == null) return null;
        return attribute.getDescription();
    }

    @Override
    public PlantDescription convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;
        try{
            return PlantDescription.fromCode(dbData);
        } catch (IllegalArgumentException e){
            log.error("failure convert[{}]", dbData, e);
            throw e;
        }
    }
}

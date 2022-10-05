package com.jky.learn.validation.sequenceprovider;

import com.jky.learn.entity.File;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

public class FileNeedRegxOrPathGroupSequenceProvider implements DefaultGroupSequenceProvider<File> {

    @Override
    public List<Class<?>> getValidationGroups(File file) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        defaultGroupSequence.add(File.class); //相当于添加了默认组
        if (file != null) {
           /* if ((file.getRegx() == null || file.getRegx().equals("")) && file.getPath() != null && !file.getPath().equals("")) {
                defaultGroupSequence.add(File.RegxOrPathIsNull.class);
            }
            if ((file.getPath() == null || file.getPath().equals("")) && file.getRegx() != null && !file.getRegx().equals("")) {
                defaultGroupSequence.add(File.RegxOrPathIsNull.class);
            }*/
            //全都为空
            if ((file.getPath() == null || file.getPath().equals("")) && (file.getRegx() == null || file.getRegx().equals(""))) {
                defaultGroupSequence.add(File.RegxAndPathIsNull.class);
            }
            //都不为空
            if (file.getPath() != null && !file.getPath().equals("") && file.getRegx() != null && !file.getRegx().equals("")) {
                defaultGroupSequence.add(File.RegxAndPathNotNull.class);
            }

        }
        return defaultGroupSequence;
    }
}

package hoan.checkservice;

import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by hoan on 14/12/16.
 */

public class DIParser {

    public void inject(Object activity) throws Exception{
        Log.d("Hoan", "ac " + activity.getClass().getName());
        Field[] fields = activity.getClass().getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CustomDI.class)) {
                CustomDI customDI = field.getAnnotation(CustomDI.class);
                Log.d("Hoan", "customDI " + (customDI == null));
                field.set(activity, field.getType().newInstance());
            }
        }
    }
}

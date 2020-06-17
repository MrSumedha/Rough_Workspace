package main;

import java.util.AbstractMap;
import java.util.HashMap;

interface MyInter<T extends AbstractMap, V extends String> {
    V getSome(T t);
}

public class ParamInterfaceDemo implements MyInter {

    @Override
    public String getSome(AbstractMap hashMap) {
        return hashMap.toString();
    }

    public static void main(String[] args) {
        AbstractMap<String, Integer> map = new HashMap<>();
        map.put("Hi", 2);
        System.out.println(new ParamInterfaceDemo().getSome(map));
    }
}

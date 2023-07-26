package com.javashun.cloud.framework.common.util;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by duke on 2017/5/29.
 */
public class MapSortUtils {

    /**
     *
     * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串,包括空值<br>
     * @param paraMap   要排序的Map对象
     * @return
     */
    public static String getMapByKeyDesc(Map<String, Object> paraMap )
    {
        String buff = "";
        Map<String, Object> tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>()
            {

                @Override
                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds)
            {
                if (StringUtils.hasText(item.getKey()))
                {
                    String key = item.getKey();
                    String val = item.getValue().toString();
                    buf.append(key + "=" + val);
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }
    /**
     * 不包括空值
     * @param paraMap
     * @return
     */
    public static String getMapByKeyDescWX(Map<String, String> paraMap )
    {
        String buff = "";
        Map<String, String> tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()
            {

                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds)
            {
                if (StringUtils.hasText(item.getKey()) && StringUtils.hasText(item.getValue()) )
                {
                    String key = item.getKey();
                    String val = item.getValue().toString();
                    buf.append(key + "=" + val);
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }

    /**
     * 不包括空值
     * @param paraMap
     * @return
     */
    public static String getMapByKeyDesc2(Map<String, Object> paraMap )
    {
        String buff = "";
        Map<String, Object> tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>()
            {

                @Override
                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds)
            {
                if (!StringUtils.isEmpty(item.getKey()) && item.getValue()!=null && !StringUtils.isEmpty(item.getValue().toString()) )
                {
                    String key = item.getKey();
                    String val = item.getValue().toString();
                    buf.append(key + "=" + val);
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }


    /**
     * 不包括空值 按照插入值存入
     * @param paraMap
     * @return
     */
    public static String getMapByKeyDesc3(LinkedHashMap<String, Object> paraMap )
    {
        String buff = "";
        LinkedHashMap<String, Object> tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(tmpMap.entrySet());
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds)
            {
                if (StringUtils.hasText(item.getKey()) && StringUtils.hasText(item.getValue().toString()) )
                {
                    String key = item.getKey();
                    String val = item.getValue().toString();
                    buf.append(key + "=" + val);
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }
    public static String getMap(LinkedHashMap<String, Object> paraMap )
    {
        String buff = "";

        try
        {
            // List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(paraMap.entrySet());
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : paraMap.entrySet())
            {
                if (StringUtils.hasText(item.getValue().toString()))
                {
                    String key = item.getKey();
                    String val = item.getValue().toString();
                    buf.append(key + "=" + val);
                    //buf.append("&");
                    // buf.append(key + val);
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }

    /**
     * 不包括空值
     * @param paraMap
     * @return
     */
    public static String getMapByKeyDesc4(Map<String, Object> paraMap )
    {
        String buff = "";
        Map<String, Object> tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>()
            {
                @Override
                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds)
            {
                if (!StringUtils.isEmpty(item.getKey()) && item.getValue()!=null && !StringUtils.isEmpty(item.getValue().toString()) )
                {
                    String key = item.getKey();
                    String val = item.getValue().toString();
                    buf.append(key + ":" + val);
                    buf.append(":");
                }
            }
            buff = buf.toString();
            if (buff.isEmpty() == false)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }

    /**
     * 不包括空值
     * @param paraMap
     * @return
     */
    public static String getMapByKeyDesc5(Map<String, Object> paraMap )
    {
        String buff = "";
        Map<String, Object> tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>()
            {

                @Override
                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds)
            {
                if (!StringUtils.isEmpty(item.getKey()) && item.getValue()!=null && !StringUtils.isEmpty(item.getValue().toString()) )
                {
                    String key = item.getKey();
                    String val = item.getValue().toString();
                    buf.append(key + "&" + val);
                }
            }
            buff = buf.toString();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }

}

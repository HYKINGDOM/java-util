package com.java.util.javautil.scs.javatest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.java.util.javautil.scs.domain.TimeMap;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.primitives.Ints.asList;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author yihur
 * @description jdk 1.8 的lamada表达式的使用范例
 * @date 2019/4/23
 */
public class TestJavaStream {


    private List<Map<String, Object>> lists;

    private List<Map<String, Object>> listCopy;

    private Map<String, Object> map;


    private List<TimeMap> timeMapList;

    /**
     * 初始化数据
     */
    @Before
    public void before_map_new_hashMap() {
        //用guava的方法创建HashMap,这样初始化的时候需要制定HashMap的大小,一般大小指定为:(长度/0.75)+1
        //这样指定大小,创建的好处了以避免HashMap的频繁的扩容导致性能的损耗
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("go", "wqeqwe");
        map.put("python", "eqwe");
        map.put("java", "12sdf3");
        map.put("c++", "12fsdf3");
        map.put("JavaScript", "78797987");
        map.put("ruby", "4564");
        map.put("php", "4654654");
        map.put("c", "465465");
    }

    /**
     * 初始化数据
     */
    @Before
    public void before_java_junit() {
        lists = Lists.newArrayListWithCapacity(8);
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "theyihur");
        map.put("age", "18");
        map.put("nation", "china");
        map.put("type", "1");
        lists.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "thezys");
        map.put("age", "21");
        map.put("nation", "amirica");
        map.put("type", "2");
        lists.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "thedgd");
        map.put("age", "22");
        map.put("nation", "jipan");
        map.put("type", "3");
        lists.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "tom");
        map.put("age", "23");
        map.put("nation", "louye");
        map.put("type", "4");
        lists.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "jack");
        map.put("age", "22");
        map.put("nation", "indian");
        map.put("type", "1");
        lists.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "fice");
        map.put("age", "12");
        map.put("nation", "malaixiya");
        map.put("type", "3");
        lists.add(map);
    }

    /**
     * 初始化数据
     */
    @Before
    public void before_java_list_copy_junit() {
        listCopy = Lists.newArrayListWithCapacity(8);
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "theyihur");
        map.put("age", "18");
        map.put("nation", "china");
        map.put("type", "1");
        listCopy.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "thezys");
        map.put("age", "123");
        map.put("nation", "amirica");
        map.put("type", "2");
        listCopy.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "thedgd");
        map.put("age", "12");
        map.put("nation", "jipan");
        map.put("type", "3");
        listCopy.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "tom");
        map.put("age", "1231");
        map.put("nation", "louye");
        map.put("type", "4");
        listCopy.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "jack");
        map.put("age", "1231");
        map.put("nation", "indian");
        map.put("type", "1");
        listCopy.add(map);
        map = Maps.newHashMapWithExpectedSize(6);
        map.put("name", "fice");
        map.put("age", "31231");
        map.put("nation", "malaixiya");
        map.put("type", "3");
        listCopy.add(map);
    }

    @Before
    public void before_init_java_local_time_compete() {
        LocalDateTime localDateTime0 = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime0.plusDays(1);
        LocalDateTime localDateTime2 = localDateTime0.plusDays(5);
        LocalDateTime localDateTime3 = localDateTime0.plusDays(7);
        LocalDateTime localDateTime4 = localDateTime0.plusDays(4);

        timeMapList = Lists.newArrayList(
                new TimeMap(0, localDateTime0, 5),
                new TimeMap(1, localDateTime1, 3),
                new TimeMap(2, localDateTime2, 5),
                new TimeMap(3, null, 3),
                new TimeMap(4, localDateTime4, 5));
    }


    /**
     * 基于Lamada表达式的list和map的遍历
     */
    @Test
    public void test_java_stream_foreach() {
        //对map的遍历
        map.forEach((k, v) -> System.out.println(k + "=" + v));
        //list的遍历
        lists.forEach(e -> System.out.println(e.toString()));
        //等同于
        lists.forEach(System.out::println);
    }

    /**
     * flatMap扁平化流
     */
    @Test
    public void test_java_stream_flatMap() {
        //拼接去重
        List<Integer> together = Stream.of(asList(1, 2, 3, 4), asList(3, 4, 5, 6, 7))
                .flatMap(Collection::stream)
                .distinct()
                .collect(toList());
        System.out.println(Arrays.toString(together.toArray()));
        System.out.println("=========================================");

        //数组字符分割去重返回list
        String[] strArray = {"hello", "world"};
        List<String> res = Arrays.stream(strArray)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(res);

        System.out.println("=========================================");

        //给定两数组，返回数组对
        Integer[] nums2 = {1, 2, 3};
        Integer[] nums3 = {3, 4};
        List<Integer> nums2List = Arrays.asList(nums2);
        List<Integer> nums3List = Arrays.asList(nums3);

        //使用2个map嵌套过滤,返回一个新的list
        List<int[]> res2 = nums2List.stream().flatMap(i -> nums3List.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        res2.forEach(e -> System.out.println(Arrays.toString(e)));

        System.out.println("=========================================");
        //返回总和能被3整除的数对
        List<int[]> res3 = nums2List.stream().flatMap(i -> nums3List.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        res3.forEach(e -> System.out.println(Arrays.toString(e)));

    }

    /**
     * 找到list中的最大和最小值
     */
    @Test
    public void test_java_list_max_min() {
        List<Integer> list = Lists.newArrayList(3, 5, 2, 9, 1);
        int maxInt = list.stream()
                .max(Integer::compareTo)
                .get();
        int minInt = list.stream()
                .min(Integer::compareTo)
                .get();
        assertEquals(9, maxInt);
        assertEquals(1, minInt);
    }

    /**
     * reduce 对数据计算后返回
     */
    @Test
    public void test_java_stream_reduce() {
        int resultSum = Stream.of(45, 10, 20, 5)
                .reduce(0, Integer::sum);
        assertEquals(80, resultSum);

        int result = Stream.of(1, 2, 3, 4)
                .reduce(1, (acc, element) -> acc * element);
        assertEquals(24, result);
    }

    /**
     * map计算平方数
     */
    @Test
    public void test_java_stream_map_count() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(Arrays.toString(squareNums.toArray()));
    }


    /**
     * 对list进行排序操作
     */
    @Test
    public void test_java_list_sort_stream() {
        List<Integer> list = Lists.newArrayList(3, 5, 1, 10, 8);
        List<Integer> sortedList = list.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        assertEquals(sortedList, Lists.newArrayList(1, 3, 5, 8, 10));
    }

    /**
     * 遍历list取相应的值返回一组特定格式的数据
     * 返回值可以Collectors.进行定义
     */
    @Test
    public void test_java_stream_map() {

        Set<String> stringSet = lists.stream()
                .filter(e -> e.get("name").toString().startsWith("the"))
                .map(e -> e.get("nation").toString())
                .collect(Collectors.toSet());
        System.out.println(Arrays.toString(stringSet.toArray()));


        List<String> strings = lists.stream()
                .filter(e -> e.get("nation").toString().length() > 6)
                .map(e -> e.get("name").toString())
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(strings.toArray()));
    }

    /**
     * 统计list中某个字段的最大/最小/平均/总和
     */
    @Test
    public void test_java_stream_collection_group_by() {
        IntSummaryStatistics summaryStatistics = lists.stream().mapToInt(e -> Integer.parseInt(e.get("age").toString())).summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d, count: %d",
                summaryStatistics.getMax(),
                summaryStatistics.getMin(),
                summaryStatistics.getAverage(),
                summaryStatistics.getSum(),
                summaryStatistics.getCount());
    }

    /**
     * 数据分组操作
     */
    @Test
    public void test_group_by_java_type() {
        //数据分组
        Map<Object, List<Map<String, Object>>> type = lists.stream().collect(groupingBy(e -> e.get("type")));
        for (Map.Entry<Object, List<Map<String, Object>>> objectListEntry : type.entrySet()) {
            List<Map<String, Object>> value = objectListEntry.getValue();
        }
        System.out.println(type.toString());

        //数据分组后计数
        Map<Object, Long> collect = lists.stream().collect(groupingBy(e -> e.get("type"), counting()));
        Map<Object, Long> longMap = lists.stream().parallel().collect(groupingBy(e -> e.get("type"), counting()));

        System.out.println(longMap.toString());

        //按照类型分组之后 返回带上每组数据的其中一个字段的额list
        Map<Object, List<Object>> listMap = lists.stream().collect(groupingBy(e -> e.get("type").toString() + e.get("name"), mapping(e_ -> e_.get("name"), toList())));
        System.out.println(listMap.toString());
    }


    /**
     * 将list<map<>>中的数据取出拼接成字符串
     */
    @Test
    public void test_group_by_java_list_to_string() {
        String name = lists.stream().map(e -> e.get("name").toString()).collect(Collectors.joining(",", "[", "]"));
        System.out.println("name:" + name);
    }

    /**
     * list去重操作
     */
    @Test
    public void test_java_stream_distinct() {
        List<String> distinctList = Lists.newArrayList("a", "a", "b", "b", "c", "c");
        List<String> afterDistinctList = distinctList.stream().distinct().collect(Collectors.toList());
        System.out.println(Arrays.toString(afterDistinctList.toArray()));
    }


    /**
     * parallel()并行化操作,进行操作前会对数据进行分块,然后每块数据开辟线程运算,
     * 尽量使用list或数组作为数据源,因为parallel会对数据进行分割,
     * <p>
     * 注意:只有在数据量大的时候才能体现出并行化的效率优势
     *
     * @param
     * @return void
     * @author yihur
     * @date 2019/4/29
     */
    @Test
    public void test_java_stream_parallel() {
        int sumSize = Stream.of("Apple", "Banana", "Orange", "Pear")
                .parallel()
                .map(String::length)
                .reduce(Integer::sum)
                .get();
        assertEquals(21, sumSize);
    }


    /**
     * 并行化的方法生成数组
     * 并行化的方法数组求和
     */
    @Test
    public void test_java_array_parallel() {
        double[] values = new double[20];
        Arrays.parallelSetAll(values, i -> i);
        System.out.println(Arrays.toString(values));
        Arrays.parallelPrefix(values, Double::sum);
        System.out.println(Arrays.toString(values));
    }

    @Test
    public void test_java_lambda_match() {
        List<String> strs = Arrays.asList("a", "a", "a", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> str.equals("a"));
        long count = strs.stream().filter(str -> str.equals("a")).count();
        System.out.println(aa);// TRUE 只要有一个存在就返回true
        System.out.println(bb);// FALSE 全部都是一种类型
        System.out.println(cc);// FALSE 没有这种类型
        System.out.println(count);
    }


    /**
     * 对于嵌套for循环的lamada表达式的优化
     */
    @Test
    public void test_list_for_list() {

        //noneMatch 不满足判断条件的数据返回
        lists.stream()
                .filter(map -> listCopy.stream().noneMatch(map1 -> map.get("age").equals(map1.get("age")) && map.get("name").equals(map1.get("name"))))
                .forEach(map -> {
                    System.out.println(map.toString());
                });

        //allMatch 所有数据满足全部条件的时候返回数据
        System.out.println("==========================================");
        lists.stream()
                .filter(map -> listCopy.stream().allMatch(map1 -> map.get("age").equals(map1.get("age"))))
                .forEach(map -> {
                    System.out.println(map.toString());
                });

        //anyMatch 只有满足判断条件的数据返回
        System.out.println("==========================================");
        lists.stream()
                .filter(map -> listCopy.stream().anyMatch(map1 -> map.get("age").equals(map1.get("age"))))
                .forEach(map -> {
                    System.out.println(map.toString());
                });
    }

    @Test
    public void test_java_lambda__list_copy() {
        List<String> list1 = Lists.newArrayList();
        List<String> list2;
        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2 = list1.stream().map(string -> "stream().map()处理之后：" + string).collect(Collectors.toList());

        list2.forEach(System.out::println);
    }


    @Test
    public void test_java_list_map_data() {

        lists.forEach(e -> {
            e.put("age", e.get("age").toString().replace("2", "1111"));
        });

        System.out.println(Arrays.toString(lists.toArray()));
    }


    /**
     * filter过滤为null的条件
     */
    @Test
    public void test_java_lambda_filter_is_empty() {
        LocalDateTime localDateTime3 = LocalDateTime.now().plusDays(7);
        for (TimeMap timeMap : timeMapList) {
            System.out.println("Id:= " + timeMap.getId());
            System.out.println("LocalDateTime:= " + timeMap.getLocalDateTime());
            System.out.println("SortNum:= " + timeMap.getSortNum());
        }

        System.out.println("===================================================");

        List<TimeMap> collect3 = timeMapList
                .stream()
                .filter(e -> null != e.getLocalDateTime())
                .collect(toList());

        for (TimeMap timeMap : collect3) {
            System.out.println("Id:= " + timeMap.getId());
            System.out.println("LocalDateTime:= " + timeMap.getLocalDateTime());
            System.out.println("SortNum:= " + timeMap.getSortNum());
        }

    }

    /**
     * 对list进行比较排序
     */
    @Test
    public void test_java_lambda_list_compare_sort() {
        //下面两组方法结果是一样的就是对结果进行排序,第一个是最大值
        //timeMapList.sort((TimeMap t1, TimeMap t2) -> t1.getLocalDateTime().compareTo(t2.getLocalDateTime()));
        //reversed为从大到小排序,不加的话默认从小到大排序
        timeMapList.sort(Comparator.comparing(TimeMap::getLocalDateTime, Comparator.nullsLast(LocalDateTime::compareTo))
                .reversed());

        for (TimeMap timeMap : timeMapList) {
            System.out.println("Id:= " + timeMap.getId());
            System.out.println("LocalDateTime:= " + timeMap.getLocalDateTime());
            System.out.println("SortNum:= " + timeMap.getSortNum());
        }
    }

    /**
     * 对list进行比较排序之后返回最大值或者最小值
     */
    @Test
    public void test_java_lambda_list_compare_sort_return_max_or_min() {

        //返回最大值之前进行判空和去重
        LocalDateTime timeMap5 = timeMapList.stream()
                .filter(o -> o.getLocalDateTime() != null)
                .map(TimeMap::getLocalDateTime)
                .distinct()
                .max(LocalDateTime::compareTo)
                .orElse(null);
        System.out.println("Max Time:" + timeMap5);

        LocalDateTime timeMap7 = Optional.of(timeMapList).orElseGet(Collections::emptyList)
                .stream()
                .filter(o -> o.getId() == 888)
                .map(TimeMap::getLocalDateTime)
                .distinct()
                .max(LocalDateTime::compareTo)
                .orElse(null);

        System.out.println("Max Time:" + timeMap7);


        //返回包含最小值的对象
        TimeMap timeMap6 = timeMapList
                .stream()
                .min(Comparator.comparing(TimeMap::getLocalDateTime))
                .orElse(null);
        System.out.println("Max Time:" + Objects.requireNonNull(timeMap6).getLocalDateTime());

        for (TimeMap timeMap : timeMapList) {
            System.out.println("LocalDateTime:= " + timeMap.getLocalDateTime());
        }

    }


    /**
     * List对象多条件排序
     */
    @Test
    public void test_java_lambda_list_multiple_compare_sort_return_max_or_min() {

        timeMapList.sort((t1, t2) -> {
            if (t1.getSortNum().equals(t2.getSortNum())) {
                return t1.getLocalDateTime().compareTo(t2.getLocalDateTime());
            } else {
                return t1.getSortNum().compareTo(t2.getSortNum());
            }
        });
        for (TimeMap timeMap : timeMapList) {
            System.out.println("Id:= " + timeMap.getId());
            System.out.println("LocalDateTime:= " + timeMap.getLocalDateTime());
            System.out.println("SortNum:= " + timeMap.getSortNum());
        }
    }

    /**
     * groupby分组加入判空
     */
    @Test
    public void test_java_stream_group_not_null() {
        Map<LocalDateTime, List<TimeMap>> localDateTimeListMap = timeMapList
                .stream()
                .filter(e -> null != e.getLocalDateTime())
                .collect(groupingBy(TimeMap::getLocalDateTime));
        for (Map.Entry<LocalDateTime, List<TimeMap>> localDateTimeListEntry : localDateTimeListMap.entrySet()) {
            System.out.println(localDateTimeListEntry.getKey());
        }
    }


}

package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日志分析器
 */
public class LogAnalyzer {

    private String configPath = "config.ini";
    private String logPath;
    private List<String> TraceIdList;
    private Map<String, LOGOBJ> traceIdMap;

    public LogAnalyzer() {
        TraceIdList = new ArrayList<>();
        traceIdMap = new HashMap<>();
    }


    /**
     * 获取logPath
     */
    private void getPath() {

        try {

            File config = new File(configPath);
            BufferedReader reader = new BufferedReader(new FileReader(config));
            String text = null;
            while ((text = reader.readLine()) != null) {
                if (text.startsWith("path")) {
                    logPath = text.substring(5);
                }
            }
//            System.out.println(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从日志中解析出LOGOBJ对象
     */
    private void parse() {
        try {
            File logFile = new File(logPath);
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            String content = null;
            GregorianCalendar calendar;
            LOGOBJ logobj;
            List<Long> timeStampList;
            Map<String, INFOOBJ> infoMap;
            INFOOBJ infoobj;

            int line=1;

            while ((content = reader.readLine()) != null) {

//                System.out.println(content);


                int year = Integer.parseInt(content.substring(0, 4));
                int month = Integer.parseInt(content.substring(5, 7)) - 1;
                int day = Integer.parseInt(content.substring(8, 10));
                int hour = Integer.parseInt(content.substring(11, 13));
                int min = Integer.parseInt(content.substring(14, 16));
                int sec = Integer.parseInt(content.substring(17, 19));
                int millsec = Integer.parseInt(content.substring(20, 23));
//                "2017-12-08T19:02:24.510"
                calendar = new GregorianCalendar(year, month, day, hour, min, sec);
                long ct = calendar.getTimeInMillis() + millsec;

                String traceId = getTraceId(content);

                //  不存在记录
                if (traceIdMap.get(traceId) == null) {
                    logobj = new LOGOBJ();
                    infoobj= new INFOOBJ();
                    timeStampList = new ArrayList<>();
                    timeStampList.add(ct);
                    infoobj.setTimeStampList(timeStampList);
                    infoobj.setStartLine(line);
                    infoobj.setEndLine(line);
                    infoMap = new HashMap<>();
                    infoMap.put(logFile.getCanonicalPath(), infoobj);
                    logobj.setInfoMap(infoMap);
                    traceIdMap.put(traceId, logobj);

                } else { // 已存在记录，取得对应logFile路径下的时间戳list，加入时间戳
                    logobj = traceIdMap.get(traceId);

                    // 查找时间戳list
                    infoobj = logobj.getInfoMap().get(logFile.getCanonicalPath());

                    // 找不到，说明是新的文件记录
                    if (infoobj == null) {
                        timeStampList = new ArrayList<>();
                        timeStampList.add(ct);
                        infoobj.setTimeStampList(timeStampList);
                        infoobj.setStartLine(line);
                        infoobj.setEndLine(line);
                        logobj.getInfoMap().put(logFile.getCanonicalPath(), infoobj);

                    } else {
                        infoobj.getTimeStampList().add(ct);
                        infoobj.setEndLine(line);
                    }

                }


                line++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过正则表达式获取行里面的TraceId
     *
     * @param content
     * @return
     */
    private String getTraceId(String content) {

        Pattern pattern = Pattern.compile("TraceId:(.+)]");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    /**
     * 输出结果
     */
    private void output(){

        StringBuilder builder = new StringBuilder();
        builder.append("*********************\n");
        Set<Map.Entry<String,LOGOBJ>> traceIdEntries = traceIdMap.entrySet();
        for (Map.Entry<String,LOGOBJ> entry: traceIdEntries){

            LOGOBJ logobj = entry.getValue();
            Map<String,INFOOBJ> infoMap = logobj.getInfoMap();

            builder.append("traceId="+entry.getKey());
            builder.append("\n");

            for (String path :infoMap.keySet()){
                builder.append("文件路径:"+path);
                builder.append("\n");

                int lastIndex = infoMap.get(path).getTimeStampList().size();
                long costTime = infoMap.get(path).getTimeStampList().get(lastIndex-1)-infoMap.get(path).getTimeStampList().get(0);

                builder.append("耗时(毫秒):"+costTime);
                builder.append("\n");

                builder.append("开始行:"+infoMap.get(path).getStartLine());
                builder.append("\n");
                builder.append("结束行:"+infoMap.get(path).getEndLine());


                builder.append("\n*********************\n");

            }

        }

        System.out.println(builder.toString());

    }

    public static void main(String... args) {

        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.getPath();
        analyzer.parse();
//        System.out.println(analyzer.getTraceId("2017-12-08T19:02:24.510+0800:DEBUG xxxxxxxxxxxx [TraceId:d6053123-1313-4654-9494-0101616465] xxxxxxxx"));
        analyzer.output();

    }




}

class LOGOBJ {

    private Map<String, INFOOBJ> infoMap;    // key=log文件路径 value=List<Long> timeStampList


    public LOGOBJ() {
    }


    public Map<String, INFOOBJ> getInfoMap() {
        return infoMap;
    }

    public void setInfoMap(Map<String, INFOOBJ> infoMap) {
        this.infoMap = infoMap;
    }
}

class INFOOBJ{

    private List<Long> timeStampList;
    private int startLine;  // 记录开始行
    private int endLine;    // 记录结束行

    public List<Long> getTimeStampList() {
        return timeStampList;
    }

    public void setTimeStampList(List<Long> timeStampList) {
        this.timeStampList = timeStampList;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }
}

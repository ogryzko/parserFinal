import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by genya on 05/08/2017.
 */
public class ValidationTest {
    private final String SEGMENT_ID = "ID01\t21\t19 12\t982429\t20120707\tОУФМС России по Москве\t\t".toUpperCase();
    private final String SEGMENT_TUTDF = "TUTDF\t4.0r\t20150701\t1301ZZ013006\t\t20160102\t4d9e6s8w\t".toUpperCase();
    private final String SEGMENT_NA = "NA01\tПортугалин\tСергеевич\tПетр\t\t19880710\tМосква\t\t\t\t\t\t".toUpperCase();
    private final String SEGMENT_TRLR = "TRLR\t".toUpperCase();
    private final String SEGMENT_TR = "TR01\t1452pp011001\t45859874585\t09\t1\t20160610\t20160712\t00\t20160713\t20160713\t5000\t0\t0\t0\t7\t1\tRUB\t\t20160701\t20160701\t20160701\t7\t\t\t0\tN\t\t\t\tN\t\t\t\t\t\t\t\t\t\t\t\t".toUpperCase();

    private final String A = "[А-ЯЁA-Z]";
    private final String N = "\\\\d";
    private final String S = "[\\\\+\\\\d]";
    private final String Q = "[А-ЯЁA-Z0-9]";
    private final String P = ".";
    private final String D = "\\\\d";
    private final String C = "[А-ЯЁA-Z\\\\.\\\\, '\\\\-]";

    @Test
    public void test(){
        String regex = "\\s*([А-ЯЁA-Z]{5})\\s*\t\\s*(.{4,6})\\s*\t\\s*(\\d{8})\\s*\t\\s*([А-ЯЁA-Z0-9]{12})\\s*\t\\s*(.{0,8})\\s*\t\\s*(\\d{8})\\s*\t\\s*([А-ЯЁA-Z0-9]{8})\\s*\t\\s*(.{0,80})\\s*";
        regex = "\\s*([А-ЯЁA-Z0-9]{4})\\s*\t\\s*(\\d{2})\\s*\t(.{0,20})\\s*\t\\s*([\\w^_]{0,20})\\s*\t(\\d{8}|.{0})\\s*\t(.{0,510})\\s*\t\\s*(.{0,510})\\s*\t";
        Map<String,String> tokens = new HashMap<>();
        tokens.put("A", A);
        tokens.put("P", P);
        tokens.put("D", D);
        tokens.put("Q", Q);
        tokens.put("N", N);
        tokens.put("S", S);
        tokens.put("C", C);
        tokens.put(" ", "\\\\s*\t\\\\s*");

        String preRegex = "(A{5}) (P{4,6}) (D{8}) (Q{12}) (P{0,8}) (D{8}) (Q{8}) (P{0,80})";
        //preRegex = "(Q{4}) (N{2}) (P{0,20}) (Q{0,20}) (D{8}|D{0}) (P{0,510}) (P{0,510}) (P{0,20})";
        //preRegex = "(A{4}) (N{0,9})";
        //preRegex = "(Q{4}) (C{1,60}) (C{0,60}) (C{1,60}) (N{0,1}) (D{8}) (P{1,1020}) (A{0,2}) (N{0,1}) (N{0,2}) (N{0,1}) (C{0,60}) (C{0,60})";
        //preRegex = "(Q{8})";
        String patternString = "(A|P|D| |Q|N|S|C)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(preRegex);

        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(sb, tokens.get(matcher.group(1)));
        }
        matcher.appendTail(sb);
        sb.append("\\s*");
        sb.insert(0, "\\s*");
        String regex2 = sb.toString();
        System.out.println(regex2);
        Pattern idp = Pattern.compile(regex2);
        Matcher idm = idp.matcher(SEGMENT_TUTDF);
        idm.matches();
        int groupCount = idm.groupCount();
        List<String> fileds = new ArrayList<>();
        for (int i = 1; i < groupCount; i++) {
            fileds.add(idm.group(i));
        }
        List<String> unnModifieble = Collections.unmodifiableList(fileds);
        System.out.println(fileds);
    }
}

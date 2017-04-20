package algorithm;

import org.ansj.library.UserDefineLibrary;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.nlpcn.commons.lang.tire.domain.Value;
import org.nlpcn.commons.lang.tire.library.Library;

public class Bayesian {
    public final static String input2 = "你好，请问牙刷单价是多少？";
    public static void main(String[] args) {
        UserDefineLibrary.insertWord("1号店", "n", UserDefineLibrary.DEFAULT_FREQ);
        UserDefineLibrary.insertWord("收菜","v", UserDefineLibrary.DEFAULT_FREQ);
        UserDefineLibrary.insertWord("自动发货","v", UserDefineLibrary.DEFAULT_FREQ);
        UserDefineLibrary.insertWord("刷单","v", UserDefineLibrary.DEFAULT_FREQ);
        Value value = new Value("牙刷单价", "牙刷", "n", "单价", "n");
        Library.insertWord(UserDefineLibrary.ambiguityForest, value);
//            Result parseResult0 = DicAnalysis.parse(input);
        System.out.println(DicAnalysis.parse(input2));
    }
}



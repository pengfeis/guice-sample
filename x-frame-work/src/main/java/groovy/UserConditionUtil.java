package groovy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author supengfei
 * @date 2020/12/17 13:37
 */
public class UserConditionUtil {


    public static String genLogicExpr(Rule ruleConf) {

        List<String> exprList = new ArrayList<>();
        List<Rule> ruleConfList = ruleConf.getRuleList();

        for (Rule conf : ruleConfList) {
            String raw = conf.getExprList().stream().map(i -> {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(i.getLeft());
                sb.append(i.getOpt());
                sb.append(i.getRight());
                sb.append(")");
                return sb.toString();
            }).collect(Collectors.joining(conf.getLogicSymbol()));
            exprList.add(raw);
        }
        String expr = exprList.stream().map(i -> new StringBuilder().append("(").append(i).append(")"))
                .collect(Collectors.joining(ruleConf.getLogicSymbol()));
        return expr;
    }

    public static class Expr {

        public Expr() {
        }

        public Expr(String left, String opt, Object value) {
            this.left = left;
            this.opt = opt;
            this.right = value;
        }

        public String getLeft() {
            return left;
        }

        public void setLeft(String left) {
            this.left = left;
        }

        public String getOpt() {
            return opt;
        }

        public void setOpt(String opt) {
            this.opt = opt;
        }

        public Object getRight() {
            return right;
        }

        public void setRight(Object right) {
            this.right = right;
        }

        String left;
        String opt;
        Object right;


    }

    public static class Rule {
        private String logicSymbol;
        private List<Expr> exprList;
        private List<Rule> ruleList;


        public String getLogicSymbol() {
            return logicSymbol;
        }

        public void setLogicSymbol(String logicSymbol) {
            this.logicSymbol = logicSymbol;
        }

        public List<Expr> getExprList() {
            return exprList;
        }

        public void setExprList(List<Expr> exprList) {
            this.exprList = exprList;
        }

        public List<Rule> getRuleList() {
            return ruleList;
        }

        public void setRuleList(List<Rule> ruleList) {
            this.ruleList = ruleList;
        }
    }

    public static void main(String[] args) throws IOException {
        Expr e1 = new Expr("size", ">", "1");
        Expr e2 = new Expr("age", ">", "18");
        Expr e21 = new Expr("age", "<", "25");
        Expr e3 = new Expr("grand", "==", "\"AAA\"");

        ArrayList<Expr> iters = Lists.newArrayList(e1, e2, e3, e21);


        Rule rules = new Rule();
        rules.setLogicSymbol("||");

        Rule child = new Rule();
        child.setExprList(iters);
        child.setLogicSymbol("&&");

        rules.setRuleList(Lists.newArrayList(child, child));


        String expr = genLogicExpr(rules);

        String json = new ObjectMapper().writeValueAsString(rules);
        System.out.println(json);
        Rule ruleConf = new ObjectMapper().readValue("{\"logicSymbol\":\"||\",\"exprList\":null,\"ruleList\":[{\"logicSymbol\":\"&&\",\"exprList\":[{\"left\":\"size\",\"opt\":\">\",\"right\":\"1\"},{\"left\":\"age\",\"opt\":\">\",\"right\":\"18\"},{\"left\":\"grand\",\"opt\":\"==\",\"right\":\"\\\"AAA\\\"\"},{\"left\":\"age\",\"opt\":\"<\",\"right\":\"25\"}],\"ruleList\":null},{\"logicSymbol\":\"&&\",\"exprList\":[{\"left\":\"size\",\"opt\":\">\",\"right\":\"1\"},{\"left\":\"age\",\"opt\":\">\",\"right\":\"18\"},{\"left\":\"grand\",\"opt\":\"==\",\"right\":\"\\\"AAA\\\"\"},{\"left\":\"age\",\"opt\":\"<\",\"right\":\"25\"}],\"ruleList\":null}]}\n", Rule.class);

        String expr2 = genLogicExpr(ruleConf);
        System.out.println(expr);
        System.out.println(expr2);


    }

}

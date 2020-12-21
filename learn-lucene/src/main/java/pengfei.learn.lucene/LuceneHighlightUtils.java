package pengfei.learn.lucene;

/**
 * @author supengfei
 * @date 2020/12/4 14:48
 */
public class LuceneHighlightUtils {
    public static void main(String[] args) {
/*        String text = "中华人民共和国 是个好国家啊";
        //设置高亮文本的样式
        Formatter formatter = new SimpleHTMLFormatter("<span>", "</span>");
        //用于对索引中特定的项进行搜索
        TermQuery query = new TermQuery(new Term("field", "聪明"));
        //通过TokenStream流获取存储分词的各种信息
        TokenStream tokenStream = new StandardAnalyzer().tokenStream("field", new StringReader(text));
        //通过评分后的查询对象
        QueryScorer scorer = new QueryScorer(query, "field");
        Highlighter highlighter = new Highlighter(formatter, scorer);
//        默认情况下，highlighter内部使用的是SimpleFragmenter分成片断，如果满足不了需求，可以用SimpleSpanFragmenter
//        highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));

        System.out.println(highlighter.getBestFragment(tokenStream, text));*/
    }
}

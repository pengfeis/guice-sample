package pengfei.learn.corejava.falsesharing;

import com.google.common.base.Splitter;
import com.google.common.hash.Hashing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadFileApp {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\supengfei\\Desktop\\22HKQK20200401001.txt"));

        Map<String, Long> map = lines.stream().map(i ->
        {
            List<String> row = Splitter.on("|").trimResults().splitToList(i);

            String orderId = row.get(0);
            String peroid = row.get(5);

            String item = new StringBuilder(orderId).append("-").append(peroid).toString();
            return item;

        }).collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry);
            }
        }
    }


    static class Item {
        public String getLoanId() {
            return loanId;
        }

        public void setLoanId(String loanId) {
            this.loanId = loanId;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        private String loanId;
        private String period;

        public Item(String loanId, String period) {
            this.loanId = loanId;
            this.period = period;
        }


        @Override
        public int hashCode() {
            return Hashing.crc32().hashString(this.loanId + this.getPeriod(), Charset.defaultCharset()).asInt();
        }


        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                boolean b = item.getLoanId().equals(this.getLoanId()) && item.getPeriod().equals(this.getPeriod());
                if (b) {
                    return true;
                }

            }
            return false;
        }
    }
}

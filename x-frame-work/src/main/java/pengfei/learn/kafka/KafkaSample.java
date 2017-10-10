package pengfei.learn.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class KafkaSample {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("client.id", "DemoProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        int msgNo = 1;

        boolean isSync = false;

        while (true) {
            Thread.sleep(50);
            String msgStr = "msg_" + msgNo;
            long startTime = System.currentTimeMillis();

            if (!isSync) {
                producer.send(new ProducerRecord<>("test_pengfeis", String.valueOf(msgNo), msgStr),
                        new DemoCallback(startTime, msgNo, msgStr));
            } else {
                producer.send(new ProducerRecord<>("test_pengfeis", String.valueOf(msgNo), msgStr));
            }
            ++msgNo;
        }

    }


}

class DemoCallback implements Callback {

    private final long start;

    private final int key;

    private final String msg;


    public DemoCallback(long start, int key, String msg) {
        this.start = start;
        this.key = key;
        this.msg = msg;
    }

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        long elapsed = System.currentTimeMillis() - this.start;
        if (recordMetadata != null) {
            System.out.println(elapsed + "key: " + this.key + " with value: " + this.msg
                    + "sent to partition "
                    + recordMetadata.partition() + " with offset: " + recordMetadata.offset());
        } else {
            e.printStackTrace();
        }
    }
}

package algorithm.tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengfeisu
 */
public class GetFullPathOfLeaf {

    public static void main(String[] args) throws JsonProcessingException {

        Node kq = new Node(1000L, 100L, "康桥");
        Node zj = new Node(1002L, 100L,"张江");
        Node tz = new Node(1003L,  100L,"唐镇");

        Node pd = new Node(100L, 10L, "浦东");


        Node mh = new Node(102L, 10L, "闵行");

        Node sh = new Node(10L, 0L, "上海");

        List<Node> items = Lists.newArrayList(kq, zj, tz, pd, mh, sh);

        HashMap<Long, Node> map = new HashMap<>();


        for (Node item : items) {
            map.put(item.getId(), item);
        }


        String path = getFullPathOfLeafNode(zj, map);
        System.out.println(path);


        pd.setChildNodes(Lists.newArrayList(kq, zj, tz));
        mh.setChildNodes(new ArrayList<>());
        sh.setChildNodes(Lists.newArrayList(pd, mh));


        System.out.println(new ObjectMapper().writeValueAsString(sh));







    }

    public static String getFullPathOfLeafNode(Node node, Map<Long, Node> map) {

        List<String> path = new ArrayList<>(3);
        path.add(node.getTitle());
        Node tmp = node;

        while (!new Long(0L).equals(tmp.getPid())) {
            Node parent = map.get(tmp.getPid());
            tmp = parent;
            if (parent != null) {
                path.add(tmp.getTitle());
            }
        }

        List<String> data = new ArrayList<>(path.size());
        for (int i = path.size() -1; i >= 0; i--) {
            data.add(path.get(i));
        }

        return String.join("/", data);

    }





    public static class Node {

        public Node(Long id, Long pid, String title) {
            this.id = id;
            this.pid = pid;
            this.title = title;
        }

        private Long id;

        private Long pid;
        private String title;
        private List<Node> childNodes;

        public Long getPid() {
            return pid;
        }

        public void setPid(Long pid) {
            this.pid = pid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Node> getChildNodes() {
            return childNodes;
        }

        public void setChildNodes(List<Node> childNodes) {
            this.childNodes = childNodes;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}



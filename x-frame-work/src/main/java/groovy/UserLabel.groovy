package groovy

/**
 * @author supengfei* @date 2020/12/17 13:33
 */
class UserLabel {

    static void main(String[] args) {

        def user = new UserLabel()
        def data = ["grand": 4, "age": 18, "gender": "man", "compSize": 2]

        println user.hit(data)
    }


    class Field {
        String left;
        String opt;
        Object value;
    }

    def boolean hit(def data) {
        // data.${field} opt rt
        // logic
        // data.${field} opt rv

        return (data.grand > 3) && (data.age == 18) && (data.gender = 'female') && (data.compSize > 1)
    }
}

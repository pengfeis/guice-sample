import groovy.json.JsonSlurper;

def main(def input) {

    input = new JsonSlurper().parseText(input);

    def _ = new HashMap();

    _.GLOBAL = new HashMap();

    def result = rule_code_1(input, _, null);

    if (result == null) throw new RuntimeException("无结果");

    result.extra = _.GLOBAL;

    return result;
}




def rule_code_1(def input, def _) {
    def t = new HashMap(); t.GLOBAL = _.GLOBAL; _ = t; def _result = new HashMap();

    _.$age = $age;

    if ((true) equals("false")) {
        // _.$output = funcName (funcParam);
        _.$output = __rule_id_code_codec_1(input, _);

        // _.$result = funcName (funcParam);
        // _.$output = _.$result.output;
        // _.$hit = _.$result.hit;
        _result.output = "end1"; _result.hit = "1"; _result.node = 'end1';
    }
    return _result;
}





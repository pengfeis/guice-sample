class RulesEngine {

    def rules = [:]
    def evals = [:]

    // Separate the map into the rules and the query evaluations:

    def rules(Map rules) {
        rules.each { rule, defn ->
            // If the rule is map, then it is stored in the evals
            if (defn instanceof Map)
                evals.put(rule, defn)
            else
                this.rules.put(rule, defn)
        }
    }

    // Given a 'phrase', search the query evaluation map for a
    // matching rule &hellip;

    Object evaluate(String phrase, Object object) {
        def results = null
        evals[phrase].each { arule, evalcode ->
            def callrule = unTitleCase(arule - 'is')
            def code = rules[callrule]
            if (code && code.call(object))
                results = evalcode.call(object)
        }
        return results
    }

    // Given: CamelCased this returns camelCased
    String unTitleCase(String str) {
        str[0].toLowerCase() + str[1..str.size() - 1]
    }

    static void main(String[] args) {


    }
}
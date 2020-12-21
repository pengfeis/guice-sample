import Person
import RulesEngine

static void main(String[] args) {

    def engine = new RulesEngine()

    engine.rules([
            baby     : { person -> person.age < 3 },
            child    : { person -> person.age >= 3 && person.age < 10 },
            student  : { person -> person.age >= 10 && person.age < 21 },
            adult    : { person -> person.age >= 21 && person.age < 65 },
            senior   : { person -> person.age >= 65 },

            // We could have written the rules using the default pointer, like:
            //   child:  { it.age >=  3 && it.age < 10 }
            // But I don't like using gender neutral pronouns in this case.

            admission: [
                    isBaby   : { 0.00 },
                    isChild  : { 3.00 },
                    isStudent: { 7.00 },
                    isSenior : { 7.00 },
                    isAdult  : { 9.00 }
            ]
    ])

    def bob = new Person([name: 'Bob Barker', age: 83])

    def price = engine.evaluate('admission', bob)

    println(price)



}


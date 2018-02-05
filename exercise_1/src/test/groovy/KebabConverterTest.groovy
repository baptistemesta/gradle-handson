import spock.lang.Specification

class KebabConverterTest extends Specification {

    def "should convert input to kebab case"() {
        given:
        def kebabConverter = new KebabConverter()

        when:
        def converted = kebabConverter.convertToKebabCase("the_input_in_snake")

        then:
        //TODO: 3: fix the test
        converted == "the-input-in_snake"
    }
}

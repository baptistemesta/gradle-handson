import spock.lang.Specification

class KebabConverterTest extends Specification {

    def "should convert input to kebab case"() {
        given:
        def kebabConverter = new KebabConverter()

        when:
        def converted = kebabConverter.convertToKebabCase("the_input_in_snake")

        then:
        converted == "the-input-in-snake"
    }
}

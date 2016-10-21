package prueba.grails



import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BookService)
@Mock([Book,Author])
class BookServiceSpec extends Specification{
    Author author
    Book book

    def setup() {
        author = new Author(name:"La Sapa")
        book = new Book(title:"Sapo Pepe",author:author)

    }

    void create() {
        when:
                def bookReturned = service.create(book.title,book.author.name)
        then:
            bookReturned.title == book.title
            bookReturned.author.name == book.author.name
    }
}

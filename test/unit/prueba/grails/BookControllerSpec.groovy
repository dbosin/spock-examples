package prueba.grails

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(BookController)
@Mock([Book, Author])
class BookControllerSpec extends Specification {
	def bookServiceMock = Mock(BookService)
	Author author
	Book book
	List <Book> books

	def setup(){
		author = new Author(name:"Sarlanga")
		book = new Book(title:"Caperucita",author:author)
		book.save()
		books = [book,book]
		bookServiceMock.create(_, _) >> book
		bookServiceMock.list() >> books
		controller.bookService = bookServiceMock
	}

	void "test create a book"() {
		when:
			params.title = "Caperucita"
			params.author = "Sarlanga"
			controller.create()
		then:
			response.status == 200
			response.text == "Book ${params.title} added"
	}

	void "test list books"() {
		when:
			params.title = "Caperucita"
			params.author = "Sarlanga"
			controller.list()
		then:
			response.status == 200
		    view == "/book/list"
			model.bookList == books
	}

}

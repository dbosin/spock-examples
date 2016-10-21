package prueba.grails

class BookService {

    def create(String title, String authorName) {
		def book = new Book(title:title)
		def author = new Author(name:authorName)
		author.save()
		book.author = author
		book.save()
		return book
    }
	
	def list() {
		Book.findAll()
	}
}

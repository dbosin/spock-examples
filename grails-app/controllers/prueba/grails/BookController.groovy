package prueba.grails

class BookController {
	def bookService
	
    def create() {	
		def book = bookService.create(params.title,params.author)
		render "Book ${params.title} added"
	}
	
	def list(){
		def books = bookService.list()
		def model = [bookList:books]
		render (view: "/book/list",model:model)
	}
}

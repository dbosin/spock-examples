<table>
	 <tr>
	   <th>Titulo</th>
	   <th>Autor</th>
	 </tr>
	<g:each in="${bookList}" var="book">
		<tr>
		   <th>${book.title}</th>
		   <th>${book.author.name}</th>
  		</tr>
	</g:each>  
</table>
pdf_book_quarto:
	quarto render qproject --profile book,pdf

html_book_quarto:
	quarto render qproject --profile book,html

all_quarto: pdf_book_quarto html_book_quarto
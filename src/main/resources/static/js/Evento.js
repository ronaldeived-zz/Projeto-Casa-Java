 $('#exampleModal').on('show.bs.modal', function(event) {
	 var button = $(event.relatedTarget);
	 
	 var codigoTitulo = button.data('idEvento');
	 var descricaoTitulo = button.data('nomeEvento');
	 
	 var modal = $(this);
	 var form = modal.find('form');
	 var action = form.data('url-base');
	 if(!action.endsWith('/')){
		 action += '/';
	 }
	 form.attr('action', action + codigoTitulo);
	 
	 modal.find('.modal-body span').html('Tem certeza que deseja excluir o Evento <strong>'+ descricaoTitulo + '</strong>?');
 })
 
 $(function() {
	 $('[rel="tooltip"]').tooltip();
	 $('.js-currency').maskMoney({decimal: ',', thousands:'.', allowZero: true});
	 
	 $('.js-atualizar-status').on('click', function(event) {
		 event.preventDefault();
		 
		 var botaoReceber = $(event.currentTarget);
		 var urlReceber = botaoReceber.attr('href');
		 
		 var response = $.ajax({
			 url: urlReceber,
			 type:  'PUT'
		 });
		 
		 response.done(function(e){
			 var codigoTitulo = botaoReceber.data('codigo');
			 $('[data-role='+codigoTitulo+']').html('<span class="badge badge-success">'+ e +'</span>');
			 botaoReceber.hide();
		 });
		 
		 response.fail(function(e){
			 console.log(e);
			 alert('Erro recebendo cobrança')
		 });
	 });
		
 });
 
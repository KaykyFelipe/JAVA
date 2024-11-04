public class PedidoProdutoFacade
{
    private readonly PagamentoServico _pagamento;
    private readonly FaturaServico _fatura;
    private readonly EstoqueServico _estoque;
    private readonly EnvioServico _envio;

    public PedidoProdutoFacade()
    {
        _estoque = new EstoqueServico();
        _pagamento = new PagamentoServico();
        _fatura = new FaturaServico();
        _envio = new EnvioServico();
    }

    public void EfetuarPedido(Pedido pedido)
    {
        if (_estoque.ChecarEstoque(pedido))
        {
            _pagamento.ProcessarPagamento(pedido);
            _envio.CalcularEnvio(pedido);
            _fatura.GerarFatura(pedido);
        }
        else
        {
            Console.WriteLine("Item fora de estoque");
        }
    }
}


public class EstoqueServico
{
    public bool ChecarEstoque(Pedido pedido)
    {
        
        return true;
    }
}

public class PagamentoServico
{
    public void ProcessarPagamento(Pedido pedido)
    {
        
    }
}

public class FaturaServico
{
    public void GerarFatura(Pedido pedido)
    {
      
    }
}

public class EnvioServico
{
    public void CalcularEnvio(Pedido pedido)
    {
      
    }
}

public class Pedido {
// Detalhes do pedido
}

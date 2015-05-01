import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class ClienteGui extends Frame {

	private final String nomeCliente;
	private final TV tvRemote;
	private final Som somRemote;
	private final Cortina cortinaRemote;
	private final Ar arRemote;

	private Label status = new Label( "Status da Casa:" );
	private Label operacoes = new Label( "Operacoes Disponiveis:" );

	private Label labelTV = new Label( "TV:" );
	private CheckboxGroup tv = new CheckboxGroup();
	private Checkbox tv1 = new Checkbox( "Ligado", tv, true );
	private Checkbox tv2 = new Checkbox( "Desligado", tv, true );
	private Button ligarTV = new Button( "Ligar TV" );
	private Button desligarTV = new Button( "Desligar TV" );

	private Label labelSom = new Label( "Som:" );
	private CheckboxGroup som = new CheckboxGroup();
	private Checkbox som1 = new Checkbox( "Ligado", som, true );
	private Checkbox som2 = new Checkbox( "Desligado", som, true );
	private Button ligarSom = new Button( "Ligar Som" );
	private Button desligarSom = new Button( "Desligar Som" );

	private Label labelCortina = new Label( "Cortina.:" );
	private CheckboxGroup cortina = new CheckboxGroup();
	private Checkbox cortina1 = new Checkbox( "Aberta", cortina, true );
	private Checkbox cortina2 = new Checkbox( "Fechada", cortina, true );
	private Button ligarCortina = new Button( "Abrir Cortina" );
	private Button desligarCortina = new Button( "Fechar Cortina" );

	private Label labelAr = new Label( "Ar Condicionado:" );
	private CheckboxGroup ar = new CheckboxGroup();
	private Checkbox ar1 = new Checkbox( "Ligado", ar, true );
	private Checkbox ar2 = new Checkbox( "Desligado", ar, true );
	private Button ligarAr = new Button( "Ligar Ar" );
	private Button desligarAr = new Button( "Desligar Ar" );

	public ClienteGui( TV tv, Som som, Ar ar, Cortina cortina, String nome ) {
		this.nomeCliente = nome;
		this.tvRemote = tv;
		this.somRemote = som;
		this.arRemote = ar;
		this.cortinaRemote = cortina;
		setTitle( "Cliente = " + nomeCliente );

		setLayout( null );
		setSize( 400, 440 );
		add( status );
		add( operacoes );
		status.setBounds( 50, 60, 300, 25 );
		operacoes.setBounds( 50, 230, 300, 25 );
		status.setFont( new Font( "Times", 1, 20 ) );
		operacoes.setFont( new Font( "Times", 1, 20 ) );

		add( labelTV );
		add( tv1 );
		add( tv2 );
		add( ligarTV );
		add( desligarTV );
		tv1.setEnabled( false );
		tv2.setEnabled( false );
		labelTV.setBounds( 50, 110, 100, 25 );
		tv1.setBounds( 170, 110, 80, 25 );
		tv2.setBounds( 260, 110, 100, 25 );
		ligarTV.setBounds( 70, 270, 100, 25 );
		desligarTV.setBounds( 200, 270, 100, 25 );
		ligarTV.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						tvRemote.ligarTV( nomeCliente );
						tv1.setState( true );
						tv2.setState( false );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );
		desligarTV.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						tvRemote.desligarTV( nomeCliente );
						tv1.setState( false );
						tv2.setState( true );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );

		add( labelSom );
		add( som1 );
		add( som2 );
		add( ligarSom );
		add( desligarSom );
		som1.setEnabled( false );
		som2.setEnabled( false );
		labelSom.setBounds( 50, 130, 100, 25 );
		som1.setBounds( 170, 130, 80, 25 );
		som2.setBounds( 260, 130, 100, 25 );
		ligarSom.setBounds( 70, 300, 100, 25 );
		desligarSom.setBounds( 200, 300, 100, 25 );
		ligarSom.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						somRemote.ligarSom( nomeCliente );
						som1.setState( true );
						som2.setState( false );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );
		desligarSom.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						somRemote.desligarSom( nomeCliente );
						som1.setState( false );
						som2.setState( true );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );

		add( labelCortina );
		add( cortina1 );
		add( cortina2 );
		add( ligarCortina );
		add( desligarCortina );
		cortina1.setEnabled( false );
		cortina2.setEnabled( false );
		labelCortina.setBounds( 50, 150, 100, 25 );
		cortina1.setBounds( 170, 150, 80, 25 );
		cortina2.setBounds( 260, 150, 100, 25 );
		ligarCortina.setBounds( 70, 330, 100, 25 );
		desligarCortina.setBounds( 200, 330, 100, 25 );
		ligarCortina.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						cortinaRemote.abrirCortina( nomeCliente );
						cortina1.setState( true );
						cortina2.setState( false );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );
		desligarCortina.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						cortinaRemote.fecharCortina( nomeCliente );
						cortina1.setState( false );
						cortina2.setState( true );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );

		add( labelAr );
		add( ar1 );
		add( ar2 );
		add( ligarAr );
		add( desligarAr );
		ar1.setEnabled( false );
		ar2.setEnabled( false );
		labelAr.setBounds( 50, 170, 100, 25 );
		ar1.setBounds( 170, 170, 80, 25 );
		ar2.setBounds( 260, 170, 100, 25 );
		ligarAr.setBounds( 70, 360, 100, 25 );
		desligarAr.setBounds( 200, 360, 100, 25 );
		ligarAr.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						arRemote.ligarAr( nomeCliente );
						ar1.setState( true );
						ar2.setState( false );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );
		desligarAr.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				try {
					synchronized ( this ) {
						arRemote.desligarAr( nomeCliente );
						ar1.setState( false );
						ar2.setState( true );
					}
				} catch ( RemoteException e ) {
					e.printStackTrace();
				}
			}
		} );

	}

	// public void run() {
	// while (true) {
	// try {
	// ObjetoStatus status = servidor.getStatus();
	// tv1.setState(false);
	// tv2.setState(true);
	// som1.setState(false);
	// som2.setState(true);
	// cortina1.setState(false);
	// cortina2.setState(true);
	// ar1.setState(false);
	// ar2.setState(true);
	// } catch (RemoteException e) {
	// System.out.println("Erro ao acessar status: " + e.getMessage());
	// }
	// synchronized (this) {
	// try {
	// wait(1000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
}
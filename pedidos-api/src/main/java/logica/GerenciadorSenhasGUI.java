package logica;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GerenciadorSenhasGUI {
	private List<String> senhasCriadas = new ArrayList<>();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(GerenciadorSenhasGUI::new);
	}

	public GerenciadorSenhasGUI() {
		JFrame frame = new JFrame("Gerenciador de Senhas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new FlowLayout());

		JLabel label = new JLabel("Digite uma senha:");
		JTextField senhaField = new JTextField(20);
		JButton validarButton = new JButton("Validar Senha");
		JButton verSenhasButton = new JButton("Ver Senhas Criadas");
		JButton gerarSenhaButton = new JButton("Gerar Senha Segura");
		JButton sairButton = new JButton("Sair");
		JTextArea resultadoArea = new JTextArea(5, 30);
		resultadoArea.setEditable(false);

		validarButton.addActionListener(e -> validarSenha(senhaField.getText(), resultadoArea));
		verSenhasButton.addActionListener(e -> verSenhas(resultadoArea));
		gerarSenhaButton.addActionListener(e -> senhaField.setText(gerarSenhaSegura()));
		sairButton.addActionListener(e -> System.exit(0));

		frame.add(label);
		frame.add(senhaField);
		frame.add(validarButton);
		frame.add(verSenhasButton);
		frame.add(gerarSenhaButton);
		frame.add(sairButton);
		frame.add(new JScrollPane(resultadoArea));

		frame.setVisible(true);
	}

	private void validarSenha(String password, JTextArea resultadoArea) {
		boolean temMaiuscula = false, temMinuscula = false, temNumero = false, temEspecial = false;
		String especiais = "@#$%&*!";

		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c))
				temMaiuscula = true;
			if (Character.isLowerCase(c))
				temMinuscula = true;
			if (Character.isDigit(c))
				temNumero = true;
			if (especiais.contains(String.valueOf(c)))
				temEspecial = true;
		}

		boolean senhaValida = password.length() >= 8 && temMaiuscula && temMinuscula && temNumero && temEspecial;

		if (senhaValida) {
			resultadoArea.setText("✅ Senha válida! Sua senha foi salva.");
			senhasCriadas.add(password);
		} else {
			StringBuilder erros = new StringBuilder("❌ Senha inválida! Corrija os erros:\n");
			if (password.length() < 8)
				erros.append("- Deve ter pelo menos 8 caracteres.\n");
			if (!temMaiuscula)
				erros.append("- Deve conter pelo menos uma letra maiúscula.\n");
			if (!temMinuscula)
				erros.append("- Deve conter pelo menos uma letra minúscula.\n");
			if (!temNumero)
				erros.append("- Deve conter pelo menos um número.\n");
			if (!temEspecial)
				erros.append("- Deve conter pelo menos um caractere especial (@, #, $, %, &, *, !).\n");
			erros.append("\n🔒 Exemplo de senha forte: ").append(gerarSenhaSegura());
			resultadoArea.setText(erros.toString());
		}
	}

	private void verSenhas(JTextArea resultadoArea) {
		if (senhasCriadas.isEmpty()) {
			resultadoArea.setText("Nenhuma senha criada ainda.");
		} else {
			StringBuilder lista = new StringBuilder("🔑 Senhas Criadas:\n");
			for (String senha : senhasCriadas) {
				lista.append("- ").append(senha).append("\n");
			}
			resultadoArea.setText(lista.toString());
		}
	}

	private String gerarSenhaSegura() {
		String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String minusculas = "abcdefghijklmnopqrstuvwxyz";
		String numeros = "0123456789";
		String especiais = "@#$%&*!";
		Random random = new Random();
		StringBuilder senha = new StringBuilder();

		senha.append(maiusculas.charAt(random.nextInt(maiusculas.length())));
		senha.append(minusculas.charAt(random.nextInt(minusculas.length())));
		senha.append(numeros.charAt(random.nextInt(numeros.length())));
		senha.append(especiais.charAt(random.nextInt(especiais.length())));

		String allChars = maiusculas + minusculas + numeros + especiais;
		while (senha.length() < 8) {
			senha.append(allChars.charAt(random.nextInt(allChars.length())));
		}
		return senha.toString();
	}
}
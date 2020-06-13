package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class EditarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField matricula;
	private JTextField matriculaNova;
	private JTextField nomeAluno;
	private JTextField sexoAluno;

	public EditarAluno() {
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPrincipal jp = new JanelaPrincipal();
				setVisible(false);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton_1);	
		
		JLabel lblNewLabel = new JLabel("Matricula do aluno:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.SOUTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 164, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblSexo = new JLabel("Matricula");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSexo, 16, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSexo, 10, SpringLayout.WEST, contentPane);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblSexo);
		
		JLabel nome = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, nome, 6, SpringLayout.SOUTH, lblSexo);
		sl_contentPane.putConstraint(SpringLayout.WEST, nome, 0, SpringLayout.WEST, btnNewButton_1);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(nome);
		
		JLabel sexo = new JLabel("Sexo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, sexo, 6, SpringLayout.SOUTH, nome);
		sl_contentPane.putConstraint(SpringLayout.WEST, sexo, 0, SpringLayout.WEST, btnNewButton_1);
		sexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(sexo);
		
		matricula = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, matricula, 2, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, matricula, 6, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, matricula, 192, SpringLayout.EAST, lblNewLabel);
		contentPane.add(matricula);
		matricula.setColumns(10);
		
		matriculaNova = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, matriculaNova, 2, SpringLayout.NORTH, lblSexo);
		sl_contentPane.putConstraint(SpringLayout.WEST, matriculaNova, 6, SpringLayout.EAST, lblSexo);
		sl_contentPane.putConstraint(SpringLayout.EAST, matriculaNova, -259, SpringLayout.EAST, contentPane);
		matriculaNova.setColumns(10);
		contentPane.add(matriculaNova);
		
		nomeAluno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nomeAluno, 2, SpringLayout.NORTH, nome);
		sl_contentPane.putConstraint(SpringLayout.WEST, nomeAluno, 0, SpringLayout.WEST, matriculaNova);
		sl_contentPane.putConstraint(SpringLayout.EAST, nomeAluno, -171, SpringLayout.EAST, contentPane);
		nomeAluno.setColumns(10);
		contentPane.add(nomeAluno);
		
		sexoAluno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sexoAluno, 2, SpringLayout.NORTH, sexo);
		sl_contentPane.putConstraint(SpringLayout.WEST, sexoAluno, 35, SpringLayout.EAST, sexo);
		sl_contentPane.putConstraint(SpringLayout.EAST, sexoAluno, -191, SpringLayout.EAST, contentPane);
		sexoAluno.setColumns(10);
		contentPane.add(sexoAluno);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				AlunoController controller = new AlunoController();
				
				aluno.setMatricula(matricula.getText());
				
				if(matricula.getText().equals(controller.testeValido(matricula.getText()))) {
					if(matriculaNova.getText().equals(controller.testeValido(matriculaNova.getText())) && ( !matriculaNova.getText().equals(matricula.getText()))) {
						
						System.out.println("ja existe essa nova matricula");

					}
					else {
						System.out.println("ss");
						aluno.setMatricula(matriculaNova.getText());
						aluno.setNome(nomeAluno.getText());
						aluno.setSexo(sexoAluno.getText());
						
						controller.update(aluno,matricula.getText());
					}
				}
				else {
					System.out.println("Nao existe essa matricula");
				}
					

			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -30, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -30, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
	
	}

}

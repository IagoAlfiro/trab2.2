package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class ExcluirAluno extends JFrame {

	private JPanel contentPane;
	private JTextField matriculaAluno;
	private JTextField teste;

	ExcluirAluno() {
		
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
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				AlunoController controller = new AlunoController();
				
				if(matriculaAluno.getText().equals(controller.testeValido(matriculaAluno.getText())))
				{
					controller.delete(matriculaAluno.getText());
					teste.setText("Excluido com sucesso");
				}
				teste.setText("Matricula nao existe");
			
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JLabel matricula = new JLabel("Matricula");
		matricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.NORTH, matricula, 20, SpringLayout.SOUTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, matricula, 0, SpringLayout.WEST, btnNewButton_1);
		contentPane.add(matricula);
		
		matriculaAluno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, matriculaAluno, 2, SpringLayout.NORTH, matricula);
		sl_contentPane.putConstraint(SpringLayout.WEST, matriculaAluno, 6, SpringLayout.EAST, matricula);
		sl_contentPane.putConstraint(SpringLayout.EAST, matriculaAluno, 114, SpringLayout.EAST, matricula);
		contentPane.add(matriculaAluno);
		matriculaAluno.setColumns(10);
		
		teste = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, teste, 1, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, teste, -163, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, teste, -6, SpringLayout.WEST, btnNewButton);
		contentPane.add(teste);
		teste.setColumns(10);
		
		
	
	}
}

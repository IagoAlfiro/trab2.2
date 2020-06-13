package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField Sexo;

	public CriarAluno() {
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton_1 = new JButton("Criar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				AlunoController controller = new AlunoController();
				
				aluno.setNome(Nome.getText());
				aluno.setSexo(Sexo.getText());
				
				controller.create(aluno);
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -38, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 9, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sexo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, -44, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 113, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -115, SpringLayout.SOUTH, contentPane);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_1);
		
		Nome = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, Nome);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -5, SpringLayout.EAST, Nome);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, Nome);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Nome, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Nome, -96, SpringLayout.EAST, contentPane);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		Sexo = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, Nome, 0, SpringLayout.WEST, Sexo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Nome, -30, SpringLayout.NORTH, Sexo);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Sexo, 116, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Sexo, 93, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -22, SpringLayout.WEST, Sexo);
		sl_contentPane.putConstraint(SpringLayout.EAST, Sexo, -96, SpringLayout.EAST, contentPane);
		contentPane.add(Sexo);
		Sexo.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPrincipal jp = new JanelaPrincipal();
				setVisible(false);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(btnNewButton);
		
	}
}

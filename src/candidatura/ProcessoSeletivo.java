package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.plaf.synth.SynthScrollBarUI;

public class ProcessoSeletivo {
   public static void main(String[] args) {
	System.out.println("Processo Seletivo");
    String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"}; 
    String [] candidatosAprovados = {"","","","",""};
    selecaoCanditatos(candidatos, candidatosAprovados);
    imprimir(candidatosAprovados);
	for (String candidato : candidatosAprovados) {
		if (candidato != "") {
    	   entrandoEmContato(candidato); 
    	}
      }  
}	
   
   static void entrandoEmContato(String candidato) {
       int tentativasRealizadas = 1;
       boolean continuarTentando  = true;
       boolean atendeu  = false;
       do {
    	   atendeu = atender();
    	   continuarTentando = !atendeu;
    	   if (continuarTentando) {
    		   tentativasRealizadas++; 
    	   } else {
    		   System.out.println("Contato relizado com sucesso!");
    	   }
    	  
       } while (continuarTentando && tentativasRealizadas <3);
       
       if (atendeu) {
    	   System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa." );
       } else {
    	   System.out.println("Não Conseguimos contato com " + candidato + ", numero maxico de tentativas " + tentativasRealizadas);
       }
   }
   
   static boolean atender() {
	   return new Random().nextInt(3)==1;
   }
   
   static void analisarCandidato(double salarioPretendido) {
	 double salarioBase = 2000.0;
	 if (salarioBase > salarioPretendido) {
	   System.out.println("Ligar para o candidato!"); 
	   }
	   else if(salarioBase == salarioPretendido) {
		  System.out.println("Ligar para o candidato com contra proposta!"); 
	   } else {
		   System.out.println("Aguardando Resultaos dos demais candidatos!"); 
	   }
	}
   
   static double valorPretendido() {
	   return ThreadLocalRandom.current().nextDouble(1800,2200);
   }
   
   
   static void imprimir (String [] candidatos) {
	   System.out.println("Imprimir lista dos candidatos informando o indice do elemento");
	   
	   for (int indice = 0; indice < candidatos.length; indice++) {
		   if (candidatos[indice] != "") {
		   System.out.println("O canditato de n° " + (indice  +  1) + " é " + candidatos[indice]);
		   }
	    }

     for (String candidato : candidatos) {
    	 if (candidato != "") {
    	 System.out.println("O candidato selecionado foi " + candidato);
    	 }
    }
     
   }
   
   static void selecaoCanditatos(String [] candidatos, String [] candidatosAprovados) {
	   int candidatosSelecionados = 0;
	   int candidatoAtual = 0;
	   double salarioBase = 2000.0;
	   
	   while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
	     	Double valorPretendico = valorPretendido();
	      	System.out.println("Candidato " + candidatos[candidatoAtual] + " salario " + valorPretendico);
	     	analisarCandidato(valorPretendico);
	     	if (salarioBase > valorPretendico) {
	     		candidatosAprovados[candidatosSelecionados] = candidatos[candidatoAtual];
	     		candidatosSelecionados = candidatosSelecionados + 1;
	     	}
	     	candidatoAtual = candidatoAtual + 1;
 	}
   }
}

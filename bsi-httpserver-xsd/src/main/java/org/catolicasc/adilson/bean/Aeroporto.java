package org.catolicasc.adilson.bean;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@AllArgsConstructor( access = AccessLevel.PUBLIC )
@Data
@NoArgsConstructor
public class Aeroporto {
	private String nome;
	private boolean internacional;
	private Cidade cidade;

}

package org.catolicasc.adilson.bean;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@AllArgsConstructor( access = AccessLevel.PUBLIC )
@NoArgsConstructor
@Data
public class Cidade {
	private String cidade;
	private String uf;
	private String pais;

}

package org.catolicasc.adilson.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement( name = "aeroportos" )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
@NoArgsConstructor
public class ListaAeroporto {
	private List<Aeroporto> listaAeroporto;

}

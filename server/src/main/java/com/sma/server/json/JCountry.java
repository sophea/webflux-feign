package com.sma.server.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * It is used for IntelliJ IDEA By Manulife Digital Cambodia team.
 *
 * @author Sophea Mak
 * @since April-2023
 */
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JCountry implements Serializable {

    private String code;

    private String name;

}
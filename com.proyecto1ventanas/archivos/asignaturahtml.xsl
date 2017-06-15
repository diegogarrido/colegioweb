<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="java/object">
        <HTML>
            <HEAD>
                <TITLE>Notas de la Asignatura</TITLE>
            </HEAD>
            <BODY>
                <xsl:for-each select="void">
                    <P>
                        <xsl:value-of select="string"/>
                    </P>
                </xsl:for-each>
            </BODY>
        </HTML>
    </xsl:template>
</xsl:stylesheet> 
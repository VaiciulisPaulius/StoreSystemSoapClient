<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ns2="http://eif.viko.lt/pvaiciulis/springsoap/gen">

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Receipt</title>
            </head>
            <body>
                <h1>Receipt Details</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Subtotal</th>
                        <th>Total</th>
                        <th>Discount Card</th>
                        <th>Person</th>
                    </tr>
                    <xsl:apply-templates select="//ns2:receipt"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="ns2:receipt">
        <tr>
            <td><xsl:value-of select="ns2:id"/></td>
            <td><xsl:value-of select="ns2:subtotal"/></td>
            <td><xsl:value-of select="ns2:total"/></td>
            <td>
                <xsl:value-of select="concat('Barcode: ', ns2:discount_card/ns2:barCode, ', Name: ', ns2:discount_card/ns2:name)"/>
            </td>
            <td>
                <xsl:value-of select="concat('Name: ', ns2:discount_card/ns2:person/ns2:firstName, ' ', ns2:discount_card/ns2:person/ns2:lastName, ', Phone: ', ns2:discount_card/ns2:person/ns2:phoneNumber)"/>
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
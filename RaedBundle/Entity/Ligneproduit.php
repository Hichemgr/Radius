<?php

namespace SlimBundle\Entity;

/**
 * Ligneproduit
 */
class Ligneproduit
{
    /**
     * @var integer
     */
    private $quantite;

    /**
     * @var integer
     */
    private $idligne;

    /**
     * @var \AppBundle\Entity\Produit
     */
    private $idproduit;

    /**
     * @var \AppBundle\Entity\Panier
     */
    private $idpanier;


    /**
     * Set quantite
     *
     * @param integer $quantite
     *
     * @return Ligneproduit
     */
    public function setQuantite($quantite)
    {
        $this->quantite = $quantite;

        return $this;
    }

    /**
     * Get quantite
     *
     * @return integer
     */
    public function getQuantite()
    {
        return $this->quantite;
    }

    /**
     * Get idligne
     *
     * @return integer
     */
    public function getIdligne()
    {
        return $this->idligne;
    }

    /**
     * Set idproduit
     *
     * @param \AppBundle\Entity\Produit $idproduit
     *
     * @return Ligneproduit
     */
    public function setIdproduit(\AppBundle\Entity\Produit $idproduit = null)
    {
        $this->idproduit = $idproduit;

        return $this;
    }

    /**
     * Get idproduit
     *
     * @return \AppBundle\Entity\Produit
     */
    public function getIdproduit()
    {
        return $this->idproduit;
    }

    /**
     * Set idpanier
     *
     * @param \AppBundle\Entity\Panier $idpanier
     *
     * @return Ligneproduit
     */
    public function setIdpanier(\AppBundle\Entity\Panier $idpanier = null)
    {
        $this->idpanier = $idpanier;

        return $this;
    }

    /**
     * Get idpanier
     *
     * @return \AppBundle\Entity\Panier
     */
    public function getIdpanier()
    {
        return $this->idpanier;
    }
}


<?php

namespace SlimBundle\Entity;

/**
 * Produit
 */
class Produit
{
    /**
     * @var string
     */
    private $nomproduit;

    /**
     * @var float
     */
    private $prix;

    /**
     * @var integer
     */
    private $quantite;

    /**
     * @var float
     */
    private $note;

    /**
     * @var string
     */
    private $description;

    /**
     * @var string
     */
    private $saison;

    /**
     * @var string
     */
    private $imagep;

    /**
     * @var integer
     */
    private $idproduit;


    /**
     * Set nomproduit
     *
     * @param string $nomproduit
     *
     * @return Produit
     */
    public function setNomproduit($nomproduit)
    {
        $this->nomproduit = $nomproduit;

        return $this;
    }

    /**
     * Get nomproduit
     *
     * @return string
     */
    public function getNomproduit()
    {
        return $this->nomproduit;
    }

    /**
     * Set prix
     *
     * @param float $prix
     *
     * @return Produit
     */
    public function setPrix($prix)
    {
        $this->prix = $prix;

        return $this;
    }

    /**
     * Get prix
     *
     * @return float
     */
    public function getPrix()
    {
        return $this->prix;
    }

    /**
     * Set quantite
     *
     * @param integer $quantite
     *
     * @return Produit
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
     * Set note
     *
     * @param float $note
     *
     * @return Produit
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return float
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Produit
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set saison
     *
     * @param string $saison
     *
     * @return Produit
     */
    public function setSaison($saison)
    {
        $this->saison = $saison;

        return $this;
    }

    /**
     * Get saison
     *
     * @return string
     */
    public function getSaison()
    {
        return $this->saison;
    }

    /**
     * Set imagep
     *
     * @param string $imagep
     *
     * @return Produit
     */
    public function setImagep($imagep)
    {
        $this->imagep = $imagep;

        return $this;
    }

    /**
     * Get imagep
     *
     * @return string
     */
    public function getImagep()
    {
        return $this->imagep;
    }

    /**
     * Get idproduit
     *
     * @return integer
     */
    public function getIdproduit()
    {
        return $this->idproduit;
    }
    public function __toString(){
        // to show the name of the Category in the select
        return $this->nomproduit;
        // to show the id of the Category in the select
        // return $this->id;
    }
}


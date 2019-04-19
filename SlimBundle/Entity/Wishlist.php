<?php

namespace SlimBundle\Entity;

/**
 * Wishlist
 */
class Wishlist
{
    /**
     * @var string
     */
    private $nom;

    /**
     * @var float
     */
    private $prix;

    /**
     * @var integer
     */
    private $cin;

    /**
     * @var \DateTime
     */
    private $dateajout;

    /**
     * @var integer
     */
    private $idwishlist;


    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Wishlist
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prix
     *
     * @param float $prix
     *
     * @return Wishlist
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
     * Set cin
     *
     * @param integer $cin
     *
     * @return Wishlist
     */
    public function setCin($cin)
    {
        $this->cin = $cin;

        return $this;
    }

    /**
     * Get cin
     *
     * @return integer
     */
    public function getCin()
    {
        return $this->cin;
    }

    /**
     * Set dateajout
     *
     * @param \DateTime $dateajout
     *
     * @return Wishlist
     */
    public function setDateajout($dateajout)
    {
        $this->dateajout = $dateajout;

        return $this;
    }

    /**
     * Get dateajout
     *
     * @return \DateTime
     */
    public function getDateajout()
    {
        return $this->dateajout;
    }

    /**
     * Get idwishlist
     *
     * @return integer
     */
    public function getIdwishlist()
    {
        return $this->idwishlist;
    }
}


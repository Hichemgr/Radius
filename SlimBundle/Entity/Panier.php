<?php

namespace SlimBundle\Entity;

/**
 * Panier
 */
class Panier
{
    /**
     * @var string
     */
    private $etat;

    /**
     * @var integer
     */
    private $idpanier;

    /**
     * @var \AppBundle\Entity\Utilisateur
     */
    private $idutilisateur;


    /**
     * Set etat
     *
     * @param string $etat
     *
     * @return Panier
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return string
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Get idpanier
     *
     * @return integer
     */
    public function getIdpanier()
    {
        return $this->idpanier;
    }

    /**
     * Set idutilisateur
     *
     * @param \AppBundle\Entity\Utilisateur $idutilisateur
     *
     * @return Panier
     */
    public function setIdutilisateur(\AppBundle\Entity\Utilisateur $idutilisateur = null)
    {
        $this->idutilisateur = $idutilisateur;

        return $this;
    }

    /**
     * Get idutilisateur
     *
     * @return \AppBundle\Entity\Utilisateur
     */
    public function getIdutilisateur()
    {
        return $this->idutilisateur;
    }
}


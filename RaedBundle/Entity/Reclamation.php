<?php

namespace SlimBundle\Entity;

/**
 * Reclamation
 */
class Reclamation
{
    /**
     * @var string
     */
    private $nomproduit;

    /**
     * @var string
     */
    private $sujet;

    /**
     * @var string
     */
    private $contenu;

    /**
     * @var integer
     */
    private $etat;

    /**
     * @var integer
     */
    private $idreclamation;

    /**
     * @var \AppBundle\Entity\Utilisateur
     */
    private $idutilisateur;


    /**
     * Set nomproduit
     *
     * @param string $nomproduit
     *
     * @return Reclamation
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
     * Set sujet
     *
     * @param string $sujet
     *
     * @return Reclamation
     */
    public function setSujet($sujet)
    {
        $this->sujet = $sujet;

        return $this;
    }

    /**
     * Get sujet
     *
     * @return string
     */
    public function getSujet()
    {
        return $this->sujet;
    }

    /**
     * Set contenu
     *
     * @param string $contenu
     *
     * @return Reclamation
     */
    public function setContenu($contenu)
    {
        $this->contenu = $contenu;

        return $this;
    }

    /**
     * Get contenu
     *
     * @return string
     */
    public function getContenu()
    {
        return $this->contenu;
    }

    /**
     * Set etat
     *
     * @param integer $etat
     *
     * @return Reclamation
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return integer
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Get idreclamation
     *
     * @return integer
     */
    public function getIdreclamation()
    {
        return $this->idreclamation;
    }

    /**
     * Set idutilisateur
     *
     * @param \AppBundle\Entity\Utilisateur $idutilisateur
     *
     * @return Reclamation
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

